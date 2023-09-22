package com.example.polls.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.model.PaymentTerrain;
import com.example.polls.model.Receipt;
import com.example.polls.model.ReservationTerrain;
import com.example.polls.repository.FieldRepository;
import com.example.polls.repository.FielddetailRepository;
import com.example.polls.repository.PaymentRepository;
import com.example.polls.repository.ReceiptRepository;
import com.example.polls.repository.ReservationTerrainRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarService {

    @Autowired
    private ReservationTerrainRepository reservationRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private FielddetailRepository fieldDetailRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ReceiptRepository receiptRepository;

    public ReservationTerrain getReservationsByFieldId(Long  fieldId) {
        return reservationRepository.findById(fieldId).get();
    }

    public void createReservation(ReservationTerrain reservation) {
        ReservationTerrain savedReservation = reservationRepository.save(reservation);

        // Create Payment
        PaymentTerrain payment = new PaymentTerrain();
        payment.setId(savedReservation.getId());
        payment.setTotalAmount(savedReservation.getTotal());
        payment.setPaymentDate(new Date());
        PaymentTerrain savedPayment = paymentRepository.save(payment);

        // Create Receipt
        Receipt receipt = new Receipt();
        receipt.setId(savedReservation.getId());
        receipt.setFieldId(savedReservation.getFieldId());
        receipt.setTotalprice(savedReservation.getTotal());
        receipt.setPaymentId(savedPayment.getId());
        receiptRepository.save(receipt);
    }

    public ReservationTerrain getReservationById(Long id) {
        return reservationRepository.findById(id).get();

    }

    public List<ReservationTerrain> searchReservations(String title) {
        return reservationRepository.findByTitleContainingIgnoreCase(title);
    }
}
