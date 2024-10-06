package se331.lab.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.rest.DTO.auctions.AuctionDTO;
import se331.lab.rest.DTO.auctions.BidDTO;
import se331.lab.rest.entity.*;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);


    AuctionDTO getAuctionDTO(Auction auction);
    List<AuctionDTO> getAuctionDTO(List<Auction> auction);

    BidDTO getBidDTO(Bid bid);
    List<BidDTO> getBidDTO(List<Bid> bids);
}