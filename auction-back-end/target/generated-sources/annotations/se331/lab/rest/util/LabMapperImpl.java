package se331.lab.rest.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.lab.rest.DTO.auctions.AuctionBidDTO;
import se331.lab.rest.DTO.auctions.AuctionDTO;
import se331.lab.rest.DTO.auctions.BidDTO;
import se331.lab.rest.DTO.auctions.BidToAuctionDTO;
import se331.lab.rest.entity.Auction;
import se331.lab.rest.entity.Bid;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-06T21:18:50+0700",
    comments = "version: 1.6.0, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public AuctionDTO getAuctionDTO(Auction auction) {
        if ( auction == null ) {
            return null;
        }

        AuctionDTO.AuctionDTOBuilder auctionDTO = AuctionDTO.builder();

        auctionDTO.id( auction.getId() );
        auctionDTO.title( auction.getTitle() );
        auctionDTO.description( auction.getDescription() );
        auctionDTO.type( auction.getType() );
        auctionDTO.bids( bidListToAuctionBidDTOList( auction.getBids() ) );

        return auctionDTO.build();
    }

    @Override
    public List<AuctionDTO> getAuctionDTO(List<Auction> auction) {
        if ( auction == null ) {
            return null;
        }

        List<AuctionDTO> list = new ArrayList<AuctionDTO>( auction.size() );
        for ( Auction auction1 : auction ) {
            list.add( getAuctionDTO( auction1 ) );
        }

        return list;
    }

    @Override
    public BidDTO getBidDTO(Bid bid) {
        if ( bid == null ) {
            return null;
        }

        BidDTO.BidDTOBuilder bidDTO = BidDTO.builder();

        bidDTO.id( bid.getId() );
        bidDTO.amount( bid.getAmount() );
        bidDTO.dateTime( bid.getDateTime() );
        bidDTO.auction( auctionToBidToAuctionDTO( bid.getAuction() ) );

        return bidDTO.build();
    }

    @Override
    public List<BidDTO> getBidDTO(List<Bid> bids) {
        if ( bids == null ) {
            return null;
        }

        List<BidDTO> list = new ArrayList<BidDTO>( bids.size() );
        for ( Bid bid : bids ) {
            list.add( getBidDTO( bid ) );
        }

        return list;
    }

    protected AuctionBidDTO bidToAuctionBidDTO(Bid bid) {
        if ( bid == null ) {
            return null;
        }

        AuctionBidDTO.AuctionBidDTOBuilder auctionBidDTO = AuctionBidDTO.builder();

        auctionBidDTO.id( bid.getId() );
        auctionBidDTO.amount( bid.getAmount() );
        auctionBidDTO.dateTime( bid.getDateTime() );

        return auctionBidDTO.build();
    }

    protected List<AuctionBidDTO> bidListToAuctionBidDTOList(List<Bid> list) {
        if ( list == null ) {
            return null;
        }

        List<AuctionBidDTO> list1 = new ArrayList<AuctionBidDTO>( list.size() );
        for ( Bid bid : list ) {
            list1.add( bidToAuctionBidDTO( bid ) );
        }

        return list1;
    }

    protected BidToAuctionDTO auctionToBidToAuctionDTO(Auction auction) {
        if ( auction == null ) {
            return null;
        }

        BidToAuctionDTO.BidToAuctionDTOBuilder bidToAuctionDTO = BidToAuctionDTO.builder();

        bidToAuctionDTO.id( auction.getId() );
        bidToAuctionDTO.title( auction.getTitle() );
        bidToAuctionDTO.description( auction.getDescription() );
        bidToAuctionDTO.type( auction.getType() );

        return bidToAuctionDTO.build();
    }
}
