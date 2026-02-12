package com.coursemanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate invoiceDate;

    private double amount;
    
    private double tax;          // <-- added
    private double discount;     // <-- added
    private double finalAmount;  // <-- added

    private String status; // PAID / PENDING

    // Many invoices can belong to one student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Many invoices can belong to one course
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private java.util.List<Payment> payments;

    // ===== Getters & Setters =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(LocalDate invoiceDate) { this.invoiceDate = invoiceDate; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public double getTax() { return tax; }                  // <-- getter
    public void setTax(double tax) { this.tax = tax; }      // <-- setter

    public double getDiscount() { return discount; }        // <-- getter
    public void setDiscount(double discount) { this.discount = discount; } // <-- setter

    public double getFinalAmount() { return finalAmount; }  // <-- getter
    public void setFinalAmount(double finalAmount) { this.finalAmount = finalAmount; } // <-- setter

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
