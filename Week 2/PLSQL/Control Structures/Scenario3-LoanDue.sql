DECLARE
BEGIN
    FOR loan_record IN (
        SELECT l.LoanID,
               c.Name,
               l.EndDate
        FROM Loans l
        JOIN Customers c
        ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || loan_record.Name ||
            ', your loan (Loan ID: ' || loan_record.LoanID ||
            ') is due on ' || TO_CHAR(loan_record.EndDate,'DD-MON-YYYY')
        );

    END LOOP;
END;
/