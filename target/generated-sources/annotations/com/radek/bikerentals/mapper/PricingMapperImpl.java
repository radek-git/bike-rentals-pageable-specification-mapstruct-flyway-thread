package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.PricingDTO;
import com.radek.bikerentals.entity.Pricing;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-03T19:19:17+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12 (Oracle Corporation)"
)
@Component
public class PricingMapperImpl implements PricingMapper {

    @Override
    public PricingDTO toDTO(Pricing pricing) {
        if ( pricing == null ) {
            return null;
        }

        PricingDTO pricingDTO = new PricingDTO();

        pricingDTO.setId( pricing.getId() );
        pricingDTO.setName( pricing.getName() );
        pricingDTO.setPrice( pricing.getPrice() );

        return pricingDTO;
    }

    @Override
    public List<PricingDTO> toDTO(List<Pricing> pricings) {
        if ( pricings == null ) {
            return null;
        }

        List<PricingDTO> list = new ArrayList<PricingDTO>( pricings.size() );
        for ( Pricing pricing : pricings ) {
            list.add( toDTO( pricing ) );
        }

        return list;
    }

    @Override
    public Pricing toEntity(PricingDTO pricingDTO) {
        if ( pricingDTO == null ) {
            return null;
        }

        Pricing pricing = new Pricing();

        pricing.setId( pricingDTO.getId() );
        pricing.setName( pricingDTO.getName() );
        pricing.setPrice( pricingDTO.getPrice() );

        return pricing;
    }

    @Override
    public List<Pricing> toEntity(List<PricingDTO> pricingDTOList) {
        if ( pricingDTOList == null ) {
            return null;
        }

        List<Pricing> list = new ArrayList<Pricing>( pricingDTOList.size() );
        for ( PricingDTO pricingDTO : pricingDTOList ) {
            list.add( toEntity( pricingDTO ) );
        }

        return list;
    }
}
