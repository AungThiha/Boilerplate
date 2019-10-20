package thiha.aung.boilerplate.core.data.remote

interface RemoteEntityMapper<in R, out E> {
    fun mapFromRemote(remote: R): E
}