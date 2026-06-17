package br.com.alura.marketplace.infra.mapper;

import br.com.alura.marketplace.domain.entity.Foto;
import br.com.alura.marketplace.domain.entity.Produto;
import br.com.alura.marketplace.infra.msg.FotoMsg;
import br.com.alura.marketplace.infra.msg.ProdutoMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-17T19:22:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.11 (Ubuntu)"
)
public class ProdutoMsgMapperImpl implements ProdutoMsgMapper {

    @Override
    public ProdutoMsg converter(Produto source) {
        if ( source == null ) {
            return null;
        }

        ProdutoMsg.ProdutoMsgBuilder produtoMsg = ProdutoMsg.builder();

        produtoMsg.produtoId( source.getProdutoId() );
        produtoMsg.nome( source.getNome() );
        produtoMsg.categoria( source.getCategoria() );
        produtoMsg.status( source.getStatus() );
        produtoMsg.descricao( source.getDescricao() );
        produtoMsg.valor( source.getValor() );
        produtoMsg.petStorePetId( source.getPetStorePetId() );
        produtoMsg.fotos( fotoListToFotoMsgCollection( source.getFotos() ) );
        List<String> list = source.getTags();
        if ( list != null ) {
            produtoMsg.tags( new ArrayList<String>( list ) );
        }
        produtoMsg.criadoEm( source.getCriadoEm() );
        produtoMsg.atualizadoEm( source.getAtualizadoEm() );

        return produtoMsg.build();
    }

    protected FotoMsg fotoToFotoMsg(Foto foto) {
        if ( foto == null ) {
            return null;
        }

        FotoMsg.FotoMsgBuilder fotoMsg = FotoMsg.builder();

        fotoMsg.fotoId( foto.getFotoId() );
        fotoMsg.fileName( foto.getFileName() );
        fotoMsg.link( foto.getLink() );
        fotoMsg.criadoEm( foto.getCriadoEm() );
        fotoMsg.atualizadoEm( foto.getAtualizadoEm() );

        return fotoMsg.build();
    }

    protected Collection<FotoMsg> fotoListToFotoMsgCollection(List<Foto> list) {
        if ( list == null ) {
            return null;
        }

        Collection<FotoMsg> collection = new ArrayList<FotoMsg>( list.size() );
        for ( Foto foto : list ) {
            collection.add( fotoToFotoMsg( foto ) );
        }

        return collection;
    }
}
