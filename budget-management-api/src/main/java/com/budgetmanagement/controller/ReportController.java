package com.budgetmanagement.controller;

import com.budgetmanagement.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller class for generating budget reports.
 * Provides an endpoint to retrieve summarized financial data.
 */
@RestController
@RequestMapping("/api/reports") // Base URL for report-related operations
public class ReportController {

    private final ReportService reportService;

    /**
     * Constructor to inject the ReportService dependency.
     *
     * @param reportService Service layer for generating reports.
     */
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * Retrieves a summary report based on optional query parameters.
     *
     * @param category  (Optional) The category to filter the report.
     * @param startDate (Optional) The start date for the report (format: YYYY-MM-DD).
     * @param endDate   (Optional) The end date for the report (format: YYYY-MM-DD).
     * @return A map containing the summarized report data.
     */
    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getReportSummary(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {
        return ResponseEntity.ok(reportService.generateSummary(category, startDate, endDate));
    }
}
