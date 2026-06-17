package br.com.alura.marketplace.infra.mapper;

import br.com.alura.marketplace.domain.entity.Foto;
import br.com.alura.marketplace.domain.entity.Produto;
import com.petstore.model.PetDto;
import com.petstore.model.TagDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-17T19:22:16-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.11 (Ubuntu)"
)
public class PetDtoMapperImpl implements PetDtoMapper {

    @Override
    public PetDto convert(Produto source) {
        if ( source == null ) {
            return null;
        }

        PetDto petDto = new PetDto();

        petDto.setName( source.getNome() );
        petDto.setCategory( mapStringToCategory( source.getCategoria() ) );
        petDto.setPhotoUrls( fotoListToStringList( source.getFotos() ) );
        petDto.setTags( stringListToTagDtoList( source.getTags() ) );
        petDto.setStatus( statusToStatusEnum( source.getStatus() ) );

        return petDto;
    }

    @Override
    public Produto convert(PetDto source) {
        if ( source == null ) {
            return null;
        }

        Produto.ProdutoBuilder produto = Produto.builder();

        produto.petStorePetId( source.getId() );
        produto.nome( source.getName() );
        produto.categoria( mapCategoryToString( source.getCategory() ) );
        produto.fotos( stringListToFotoCollection( source.getPhotoUrls() ) );
        produto.tags( tagDtoListToStringCollection( source.getTags() ) );
        produto.status( statusEnumToStatus( source.getStatus() ) );

        return produto.build();
    }

    @Override
    public Foto convert(String source) {
        if ( source == null ) {
            return null;
        }

        Foto.FotoBuilder foto = Foto.builder();

        foto.link( source );

        return foto.build();
    }

    protected List<String> fotoListToStringList(List<Foto> list) {
        if ( list == null ) {
            return null;
        }

        List<String> list1 = new ArrayList<String>( list.size() );
        for ( Foto foto : list ) {
            list1.add( convert( foto ) );
        }

        return list1;
    }

    protected List<TagDto> stringListToTagDtoList(List<String> list) {
        if ( list == null ) {
            return null;
        }

        List<TagDto> list1 = new ArrayList<TagDto>( list.size() );
        for ( String string : list ) {
            list1.add( mapStringToTag( string ) );
        }

        return list1;
    }

    protected PetDto.StatusEnum statusToStatusEnum(Produto.Status status) {
        if ( status == null ) {
            return null;
        }

        PetDto.StatusEnum statusEnum;

        switch ( status ) {
            case AVAILABLE: statusEnum = PetDto.StatusEnum.AVAILABLE;
            break;
            case PENDING: statusEnum = PetDto.StatusEnum.PENDING;
            break;
            case SOLD: statusEnum = PetDto.StatusEnum.SOLD;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + status );
        }

        return statusEnum;
    }

    protected Collection<Foto> stringListToFotoCollection(List<String> list) {
        if ( list == null ) {
            return null;
        }

        Collection<Foto> collection = new ArrayList<Foto>( list.size() );
        for ( String string : list ) {
            collection.add( convert( string ) );
        }

        return collection;
    }

    protected Collection<String> tagDtoListToStringCollection(List<TagDto> list) {
        if ( list == null ) {
            return null;
        }

        Collection<String> collection = new ArrayList<String>( list.size() );
        for ( TagDto tagDto : list ) {
            collection.add( mapTagToString( tagDto ) );
        }

        return collection;
    }

    protected Produto.Status statusEnumToStatus(PetDto.StatusEnum statusEnum) {
        if ( statusEnum == null ) {
            return null;
        }

        Produto.Status status;

        switch ( statusEnum ) {
            case AVAILABLE: status = Produto.Status.AVAILABLE;
            break;
            case PENDING: status = Produto.Status.PENDING;
            break;
            case SOLD: status = Produto.Status.SOLD;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + statusEnum );
        }

        return status;
    }
}
