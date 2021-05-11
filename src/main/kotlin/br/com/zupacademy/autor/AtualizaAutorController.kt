package br.com.zupacademy.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import io.micronaut.validation.Validated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Validated
@Controller("/autores")
class AtualizaAutorController(val autorRepository: AutorRepository) {

    @Put("/{id}")
    fun atualizaDescricao(@PathVariable id: Long, @NotBlank @Size(max = 400) descricao: String): HttpResponse<*> {
        // como estou recebendo apenas um campo do Json, se eu colocar a anotação @Body a informação não fica correta
        val possivelAutor = autorRepository.findById(id)
        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound<DetalhesAutorResponse?>()
        }

        val autor = possivelAutor.get()
        autor.descricao = descricao
        autorRepository.update(autor) // no spring o save cria um novo e faz update, aqui no micronaut não distintos

        return HttpResponse.ok(DetalhesAutorResponse(autor))
    }
}