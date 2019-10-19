package thiha.aung.boilerplate.core.widget

import android.content.Context

import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

/**
 * To handle a case when the Recyclerview is loaded but empty
 * code reference from <a href="https://gist.github.com/AlexZhukovich/537eaa1e3c82ef9f5d5cd22efdc80c54">here</a>
 *
 * set [toggleEmptyView] to define what to do based on isEmpty condition (adapter == null || adapter!!.itemCount == 0)
* */
class AppRecyclerView : RecyclerView {

    var toggleEmptyView : ((isEmpty: Boolean) -> Unit)? = null

    private val observer: AdapterDataObserver = object : AdapterDataObserver() {
        override fun onChanged() {
            super.onChanged()
            toggleView()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
            toggleView()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
            toggleView()
        }
        private fun toggleView() =
            toggleEmptyView?.invoke(adapter == null || adapter!!.itemCount == 0)
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override fun setAdapter(adapter: Adapter<*>?) {
        val oldAdapter = getAdapter()
        super.setAdapter(adapter)

        oldAdapter?.unregisterAdapterDataObserver(observer)

        adapter?.registerAdapterDataObserver(observer)
    }

}