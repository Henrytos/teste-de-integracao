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
    date = "2026-06-17T17:33:36-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
public class ProdutoMsgMapperImpl implements ProdutoMsgMapper {

    @Override
    public ProdutoMsg converter(Produto source) {
        if ( source == null ) {
            return null;
        }

        ProdutoMsg.ProdutoMsgBuilder produtoMsg = ProdutoMsg.builder();

        produtoMsg.atualizadoEm( source.getAtualizadoEm() );
        produtoMsg.categoria( source.getCategoria() );
        produtoMsg.criadoEm( source.getCriadoEm() );
        produtoMsg.descricao( source.getDescricao() );
        produtoMsg.fotos( fotoListToFotoMsgCollection( source.getFotos() ) );
        produtoMsg.nome( source.getNome() );
        produtoMsg.petStorePetId( source.getPetStorePetId() );
        produtoMsg.produtoId( source.getProdutoId() );
        produtoMsg.status( source.getStatus() );
        List<String> list = source.getTags();
        if ( list != null ) {
            produtoMsg.tags( new ArrayList<String>( list ) );
        }
        produtoMsg.valor( source.getValor() );

        return produtoMsg.build();
    }

    protected FotoMsg fotoToFotoMsg(Foto foto) {
        if ( foto == null ) {
            return null;
        }

        FotoMsg.FotoMsgBuilder fotoMsg = FotoMsg.builder();

        fotoMsg.atualizadoEm( foto.getAtualizadoEm() );
        fotoMsg.criadoEm( foto.getCriadoEm() );
        fotoMsg.fileName( foto.getFileName() );
        fotoMsg.fotoId( foto.getFotoId() );
        fotoMsg.link( foto.getLink() );

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
