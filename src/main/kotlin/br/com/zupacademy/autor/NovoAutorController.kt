package br.com.zupacademy.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated // sem essa anotação, o @Valid não funciona. Não é possível nem fazer o build da aplicação
@Controller("/autores") // equivalente ao @RestController e @RequestMapping do Spring
class NovoAutorController(val autorRepository: AutorRepository) {

    @Post // equivalente ao @PostMapping do Spring
    @Transactional // essa anotação não é obrigatória, pois o método save já abre uma transação com o banco
    fun cadastra(@Valid @Body autorRequest: NovoAutorRequest): HttpResponse<Any> {
        // o @Body é equivalente ao @RequestBody do Spring, porém aqui no Micronaut não é obrigatório.
        val novoAutor = autorRequest.toModel()

        autorRepository.save(novoAutor)

        val location = UriBuilder.of("/autores/{id}").expand(mutableMapOf("id" to novoAutor.id))
        return HttpResponse.created(location)
    }
}