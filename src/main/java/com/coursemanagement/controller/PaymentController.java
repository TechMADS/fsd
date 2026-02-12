package com.coursemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.coursemanagement.model.Payment;
import com.coursemanagement.service.PaymentService;
import com.coursemanagement.service.InvoiceService;

import java.time.LocalDate;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final InvoiceService invoiceService;

    public PaymentController(PaymentService paymentService,
                             InvoiceService invoiceService) {
        this.paymentService = paymentService;
        this.invoiceService = invoiceService;
    }

    // List payments
    @GetMapping
    public String listPayments(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        return "payments/payment-list";
    }

    // Show form
    @GetMapping("/add")
    public String showForm(Model model) {
        Payment payment = new Payment();
        payment.setPaymentDate(LocalDate.now());

        model.addAttribute("payment", payment);
        model.addAttribute("invoices", invoiceService.getAllInvoices());

        return "payments/add-payment";
    }

    // Save
    @PostMapping("/save")
    public String savePayment(@ModelAttribute Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "redirect:/payments";
    }
}
