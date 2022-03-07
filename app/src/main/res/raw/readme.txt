
아래와 같은 경로로 Retrofit 테스트 프로그램을 작성한다.
-------------------------------------------------------------------
최종 권한 설정을 아래와 같이 한다.
<uses-permission android:name="android.permission.INTERNET"/>
<application
    android:usesCleartextTraffic="true"
    ...
    >
</application>


--------------------------------------------------------------------
def retrofit_version = '2.9.0'
implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"


--------------------------------------------------------------------
data class EmailRequestDTO(
	@SerializedName("id") var id: String
	@SerializedName("pw") var pw: String
)
data class LoginResponse(
	@SerializedName("statusCode") var code: String
	@SerializedName("statusMessage") var message: String
	@SerializedName("data") var data: Data? = null
) {
	data class Data(
		@SerializedName("id") val userID: String,
		...
	)
}

--------------------------------------------------------------------
interface RetroBaseApiService {

	@GET("/posts/{userId}"
	fun getFirst(
		@Path("userId") id: String
	): Call<ResponseGet>

	@GET("/posts)
	fun getSecond(
		@Query("userId") id:String
	): Call<List<ResponseGet>>

	@FormUrlEncoded
	@POST("/posts")
	fun postFirst(
		@Field("title") title: String,
		@Field("author") author: String
	): Call<ResponseGet>

----------------------------------------------------------
object RetrofitClient {
	// "https://jsonplaceholder.typicode.com/todos/1"
	private const val BASE_URL = "https://jsonplaceholder.typicode.com"
	private val retrofit:Retrofit.Builder by lazy {
		Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
	}
	val instance: RetrofitAPI by lazy {
		retrofit.build().create(RetrofitAPI::class.java)

	}
}
-------------------------------------------------