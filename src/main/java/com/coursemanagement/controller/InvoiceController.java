package com.coursemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.coursemanagement.model.Invoice;
import com.coursemanagement.service.InvoiceService;
import com.coursemanagement.service.StudentService;
import com.coursemanagement.service.CourseService;

import java.time.LocalDate;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final StudentService studentService;
    private final CourseService courseService;

    public InvoiceController(InvoiceService invoiceService,
                             StudentService studentService,
                             CourseService courseService) {
        this.invoiceService = invoiceService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    // List invoices
    @GetMapping
    public String listInvoices(Model model) {
        model.addAttribute("invoices", invoiceService.getAllInvoices());
        return "invoices/invoice-list";
    }

    // Show add form
    @GetMapping("/add")
    public String showForm(Model model) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(LocalDate.now());

        model.addAttribute("invoice", invoice);
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.getAllCourses());

        return "invoices/add-invoice";
    }

    // Save invoice
    @PostMapping("/save")
    public String saveInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoices";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return "redirect:/invoices";
    }
}
