package ua.edu.cdu.boris.devmobapp.api

import retrofit2.Response
import retrofit2.http.GET
import ua.edu.cdu.boris.devmobapp.model.CompositeItem

interface ItemInterface {
    @GET("/items.json")
    suspend fun getItems() : Response<ArrayList<CompositeItem>>
}