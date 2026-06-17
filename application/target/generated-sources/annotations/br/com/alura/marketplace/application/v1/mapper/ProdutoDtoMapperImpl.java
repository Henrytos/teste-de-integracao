package br.com.alura.marketplace.application.v1.mapper;

import br.com.alura.marketplace.application.v1.dto.FotoDto;
import br.com.alura.marketplace.application.v1.dto.ProdutoDto;
import br.com.alura.marketplace.domain.entity.Foto;
import br.com.alura.marketplace.domain.entity.Produto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-17T17:33:36-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
public class ProdutoDtoMapperImpl implements ProdutoDtoMapper {

    @Override
    public Produto converter(ProdutoDto.Request source) {
        if ( source == null ) {
            return null;
        }

        Produto.ProdutoBuilder produto = Produto.builder();

        produto.nome( source.getNome() );
        produto.categoria( source.getCategoria() );
        produto.status( source.getStatus() );
        produto.descricao( source.getDescricao() );
        produto.valor( source.getValor() );
        produto.fotos( requestListToFotoCollection( source.getFotos() ) );
        List<String> list = source.getTags();
        if ( list != null ) {
            produto.tags( new ArrayList<String>( list ) );
        }

        return produto.build();
    }

    @Override
    public ProdutoDto.Response converter(Produto source) {
        if ( source == null ) {
            return null;
        }

        ProdutoDto.Response.ResponseBuilder response = ProdutoDto.Response.builder();

        response.atualizadoEm( source.getAtualizadoEm() );
        response.categoria( source.getCategoria() );
        response.criadoEm( source.getCriadoEm() );
        response.descricao( source.getDescricao() );
        response.fotos( fotoListToResponseCollection( source.getFotos() ) );
        response.nome( source.getNome() );
        response.petStorePetId( source.getPetStorePetId() );
        response.produtoId( source.getProdutoId() );
        response.status( source.getStatus() );
        List<String> list = source.getTags();
        if ( list != null ) {
            response.tags( new ArrayList<String>( list ) );
        }
        response.valor( source.getValor() );

        return response.build();
    }

    @Override
    public ProdutoDto.Representacao converterParaRepresentacao(Produto source) {
        if ( source == null ) {
            return null;
        }

        ProdutoDto.Representacao.RepresentacaoBuilder representacao = ProdutoDto.Representacao.builder();

        representacao.atualizadoEm( source.getAtualizadoEm() );
        representacao.categoria( source.getCategoria() );
        representacao.criadoEm( source.getCriadoEm() );
        representacao.nome( source.getNome() );
        representacao.produtoId( source.getProdutoId() );
        representacao.status( source.getStatus() );
        representacao.valor( source.getValor() );

        return representacao.build();
    }

    protected Foto requestToFoto(FotoDto.Request request) {
        if ( request == null ) {
            return null;
        }

        Foto.FotoBuilder foto = Foto.builder();

        foto.fileName( request.getFileName() );
        foto.base64( request.getBase64() );

        return foto.build();
    }

    protected Collection<Foto> requestListToFotoCollection(List<FotoDto.Request> list) {
        if ( list == null ) {
            return null;
        }

        Collection<Foto> collection = new ArrayList<Foto>( list.size() );
        for ( FotoDto.Request request : list ) {
            collection.add( requestToFoto( request ) );
        }

        return collection;
    }

    protected FotoDto.Response fotoToResponse(Foto foto) {
        if ( foto == null ) {
            return null;
        }

        FotoDto.Response.ResponseBuilder response = FotoDto.Response.builder();

        response.atualizadoEm( foto.getAtualizadoEm() );
        response.criadoEm( foto.getCriadoEm() );
        response.fileName( foto.getFileName() );
        response.fotoId( foto.getFotoId() );
        response.link( foto.getLink() );

        return response.build();
    }

    protected Collection<FotoDto.Response> fotoListToResponseCollection(List<Foto> list) {
        if ( list == null ) {
            return null;
        }

        Collection<FotoDto.Response> collection = new ArrayList<FotoDto.Response>( list.size() );
        for ( Foto foto : list ) {
            collection.add( fotoToResponse( foto ) );
        }

        return collection;
    }
}
