@file:Suppress("UNCHECKED_CAST")

package thiha.aung.boilerplate.core.ext.android

import androidx.fragment.app.FragmentActivity


/**
 * Retrieve argument from Activity intent
 */
fun <T : Any> FragmentActivity.argument(key: String) =
    lazy { intent.extras?.get(key) as? T ?: error("Intent Argument $key is missing") }

