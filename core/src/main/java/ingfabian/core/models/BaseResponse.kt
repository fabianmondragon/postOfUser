package ingfabian.core.models

data class BaseResponse <T> (val response: T,
                             val codeResponse: HttpStatusCode,
                             val customCode: Int
)


