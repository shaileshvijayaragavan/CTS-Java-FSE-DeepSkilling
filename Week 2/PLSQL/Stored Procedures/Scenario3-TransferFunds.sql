CREATE OR REPLACE PROCEDURE TransferFunds(
    source_account IN NUMBER,
    target_account IN NUMBER,
    transfer_amount IN NUMBER
)
AS
    source_balance NUMBER;
BEGIN
    SELECT Balance
    INTO source_balance
    FROM Accounts
    WHERE AccountID = source_account;

    IF source_balance >= transfer_amount THEN

        UPDATE Accounts
        SET Balance = Balance - transfer_amount
        WHERE AccountID = source_account;

        UPDATE Accounts
        SET Balance = Balance + transfer_amount
        WHERE AccountID = target_account;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');

    END IF;
END;
/