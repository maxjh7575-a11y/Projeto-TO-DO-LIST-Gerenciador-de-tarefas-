-- Active: 1794524834673@@127.0.0.1@5432@novo_projeto@public
CREATE TABLE tarefa(
--tabela principal de tarefas
    id SERIAL PRIMARY KEY, --cria um ID automatico sozinho a cada tarefa nova
    titulo VARCHAR(150) NOT NULL, --cria o titulo da tarefa com ate 150 letras
    descricao TEXT, -- permite escrever uma descirção mais longa do que precisa ser feito da tarefa
    status VARCHAR(50) DEFAULT 'Pendente' -- se voce não informar o status ao criar, ele ja assume automaticvamente que a tarefa esta pendente
);

SELECT * FROM tarefa;