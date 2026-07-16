DECLARE
    customer_age NUMBER;
BEGIN
    FOR customer_record IN (
        SELECT CustomerID, DOB
        FROM Customers
    ) LOOP

        customer_age := TRUNC(MONTHS_BETWEEN(SYSDATE, customer_record.DOB) / 12);

        IF customer_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer_record.CustomerID;
        END IF;

    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('1% interest rate discount applied to eligible customers.');
END;
/