-- data.sql
-- Exemplos de apólices para testes
INSERT INTO policies (numero_apolice, cpf_segurado, data_inicio, data_fim, placa_veiculo, valor_premio)
VALUES ('AP-0001', '123.456.789-09', DATE '2025-01-01', DATE '2026-01-01', 'ABC-1234', 1500.00);

INSERT INTO policies (numero_apolice, cpf_segurado, data_inicio, data_fim, placa_veiculo, valor_premio)
VALUES ('AP-0002', '987.654.321-00', DATE '2025-06-15', DATE '2026-06-15', 'XYZ-9999', 2300.50);
