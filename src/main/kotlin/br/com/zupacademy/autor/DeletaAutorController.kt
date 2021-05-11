package br.com.zupacademy.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable

@Controller("/autores")
class DeletaAutorController(private val autorRepository: AutorRepository) {

    @Delete("/{id}")
    fun deleta(@PathVariable id: Long): HttpResponse<Any> {

        if (!autorRepository.existsById(id)) {
            return HttpResponse.notFound()
        }

        autorRepository.deleteById(id)

        return HttpResponse.ok()
    }
}