package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.*;
import se331.lab.rest.repository.*;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    final AuctionRepository auctionRepository;
    final BidRepository bidRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // AUCTIONS
        Auction tempAuction;
        Bid tempBid1;
        Bid tempBid2;
        Bid tempBid3;

        // creator
        tempBid1 = bidRepository.save(
                Bid.builder()
                        .amount(BigDecimal.valueOf(55.99))
                        .dateTime("9th Jan : 10.00am")
                        .build()
        );
        tempBid2 = bidRepository.save(
                Bid.builder()
                        .amount(BigDecimal.valueOf(112.24))
                        .dateTime("9th Jan : 11.00am")
                        .build()
        );
        tempBid3 = bidRepository.save(
                Bid.builder()
                        .amount(BigDecimal.valueOf(100.00))
                        .dateTime("10th Jan : 01.00am")
                        .build()
        );

        tempAuction = auctionRepository.save(
                Auction.builder()
                        .title("Traditional Vase")
                        .description("Handle with care, do not drop, 2000 years old")
                        .type("Vase")
                        .build()
        );
        // setter
        tempAuction.setBids(List.of(tempBid1, tempBid2, tempBid3));
        tempBid1.setAuction(tempAuction);
        tempBid2.setAuction(tempAuction);
        tempBid3.setAuction(tempAuction);

        // creator
        tempBid1 = bidRepository.save(
                Bid.builder()
                        .amount(BigDecimal.valueOf(123.21))
                        .dateTime("10th Sep : 9.00am")
                        .build()
        );
        tempBid2 = bidRepository.save(
                Bid.builder()
                        .amount(BigDecimal.valueOf(456.24))
                        .dateTime("10th Sep : 11.00pm")
                        .build()
        );
        tempBid3 = bidRepository.save(
                Bid.builder()
                        .amount(BigDecimal.valueOf(99.56))
                        .dateTime("11th Sep : 09:03am")
                        .build()
        );

        tempAuction = auctionRepository.save(
                Auction.builder()
                        .title("Twin Tower Mini size")
                        .description("The exact moment we'll never forget")
                        .type("Model")
                        .build()
        );
        // setter
        tempAuction.setBids(List.of(tempBid1, tempBid2, tempBid3));
        tempBid1.setAuction(tempAuction);
        tempBid2.setAuction(tempAuction);
        tempBid3.setAuction(tempAuction);

    }



}