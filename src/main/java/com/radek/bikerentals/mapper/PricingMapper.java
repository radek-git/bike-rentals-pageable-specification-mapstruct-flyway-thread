package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.PricingDTO;
import com.radek.bikerentals.entity.Pricing;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PricingMapper {

    PricingDTO toDTO(Pricing pricing);

    List<PricingDTO> toDTO(List<Pricing> pricings);

    Pricing toEntity(PricingDTO pricingDTO);

    List<Pricing> toEntity(List<PricingDTO> pricingDTOList);
}
