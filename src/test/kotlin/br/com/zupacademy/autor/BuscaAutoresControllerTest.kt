package br.com.zupacademy.autor

import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest // para funcionar as anotações de @Inject. Por padrão já vem configurado com roolback=true
internal class BuscaAutoresControllerTest {

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @field:Inject
    lateinit var autorRepository: AutorRepository

    lateinit var autor: Autor

    @BeforeEach
    internal fun setUp() {
        // OBS.: como não fizemos configuração de banco especificamente para os testes, está sendo utilizado o Postgres
        autor = Autor("Lima Barreto", "lima@gmail.com", "Escritor do século XX")
        autorRepository.save(autor)
    }

//    @AfterEach
//    internal fun tearDown() {
//        autorRepository.deleteAll()
//    }

    @Test
    @DisplayName("deve retornar os detalhes de um autor")
    internal fun lista() {
        val autorResponse =
            client.toBlocking().exchange("/autores?email=${autor.email}", DetalhesAutorResponse::class.java)

        assertEquals(HttpStatus.OK, autorResponse.status)
        assertNotNull(autorResponse.body())
        autorResponse.body()?.let {
            assertEquals(autor.nome, it.nome)
            assertEquals(autor.email, it.email)
            assertEquals(autor.descricao, it.descricao)
        }
    }
}

/*
* @MicronautTest -> sobe o contexto do framework para assim conseguir gerenciar os Beans;
* @Inject -> pense como o @Autowired do Spring;
* toBlocking -> é para evitar fazer uma chamada assíncrona, assim vai esperar o retorno para continuar a execução das
* linhas seguintes
* */