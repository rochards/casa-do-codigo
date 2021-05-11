package br.com.zupacademy.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller("/autores")
class BuscaAutoresController(private val autorRepository: AutorRepository) {

    @Get
    fun lista(@QueryValue(defaultValue = "") email: String): HttpResponse<*> {
        // @QueryValue é equivalente ao @RequestParams do Spring. Ex.: autores?email="autor@mail.com". defaultValue é ""
        // Se vc não fornecer defaultValue = "", vc será obrigado a informar o email na request
        if (email.isEmpty()) {
            val autores = autorRepository.findAll()
            val response = autores.map(::DetalhesAutorResponse)

            return HttpResponse.ok(response)
        }

        autorRepository.findByEmail(email).also { possivelAutor ->
            return if (possivelAutor.isPresent) {
                val autor = possivelAutor.get()
                HttpResponse.ok(DetalhesAutorResponse(autor))
            } else {
                HttpResponse.notFound<DetalhesAutorResponse?>()
            }
        }
    }
}