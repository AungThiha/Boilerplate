package thiha.aung.boilerplate.core.data.local

interface LocalEntityMapper<L, E> {

    fun mapFromLocal(local: L): E

    fun mapToLocal(entity: E): L

}