package lech.gamk.net

import lech.gamk.repository.PublishedDate
import lech.gamk.repository.Result
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by Android_61 on 2017/6/8.
 * Description
 * Others
 */
interface Api {

    @GET("api/data/{type}/{pageSize}/{pageNumber}")
    fun getData(@Path("type") type: String,
                @Path("pageSize") pageSize: Int,
                @Path("pageNumber") pageNumber: Int
    ): Observable<Result>


    @GET("api/day/{year}/{month}/{day}")
    fun getDataByDate(@Path("year") year: String,
                      @Path("month") month: String,
                      @Path("day") day: String
    )

    @GET("api/day/{date}")
    fun getDateByDate(@Path("date")date:String):Observable<ResponseBody>


    @GET("history")
    fun getHistory():Observable<ResponseBody>

    @GET("api/day/history")
    fun getPublishedDAte():Observable<PublishedDate>


    companion object Factory{
        fun create():Api{
            val logging=HttpLoggingInterceptor()
            logging.level=HttpLoggingInterceptor.Level.BASIC
            val client = OkHttpClient.Builder().addInterceptor(logging).build()


            val retrofit=Retrofit.Builder()
                    .client(client)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("http://gank.io/")
                    .build()

            return  retrofit.create(Api::class.java)

        }
    }

}