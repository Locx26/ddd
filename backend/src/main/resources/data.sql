INSERT INTO customer (name, email, phone) VALUES
('John Doe', 'john@securetrust.com', '+1234567890'),
('Jane Smith', 'jane@securetrust.com', '+0987654321')
ON CONFLICT (email) DO NOTHING;

INSERT INTO account (customer_id, account_type, account_number, balance) VALUES
(1, 'SAVINGS', 'SB1001', 12500.00),
(1, 'CHECKING', 'CK1001', 8500.50),
(2, 'SAVINGS', 'SB1002', 34200.75)
ON CONFLICT (account_number) DO NOTHING;
