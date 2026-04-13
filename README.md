Automatização de Tarefas no Excel
📌 1. Introdução

Este projeto tem como objetivo automatizar tarefas no Excel, permitindo a extração de dados de um banco de dados PostgreSQL e a geração automática de relatórios em formato .xlsx.

A aplicação realiza:

Conexão com banco de dados
Consulta de dados operacionais
Aplicação de regras de negócio
Geração de planilhas Excel automatizadas

Esse tipo de solução reduz trabalho manual e melhora a produtividade na análise de dados.

🏗️ 2. Estrutura do Projeto

O projeto está organizado em pacotes seguindo uma separação de responsabilidades:

org.example
│
├── DB              → Conexão com banco de dados
├── model           → Representação dos dados (entidades)
├── repository      → Acesso aos dados (consulta SQL)
├── Server          → Regras de negócio e geração do Excel
└── Main            → Execução do sistema

🔌 3. Dependências do Projeto (Maven)
📦 PostgreSQL
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
</dependency>
Responsável pela conexão com o banco PostgreSQL.
Permite executar comandos SQL via Java.
📦 Apache POI
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.3</version>
</dependency>
Biblioteca usada para criar e manipular arquivos Excel (.xlsx).
Permite criar planilhas, linhas, células e escrever dados.


🔗 4. Camada de Banco de Dados
📌 Classe: ConnectionFactory

Responsável por criar conexões com o banco.

✔ Retorna uma conexão com o banco PostgreSQL.

📌 Classe: TesteConexao

Classe utilizada para testar se a conexão está funcionando.


📊 5. Camada de Modelo
📌 Classe: Linhas

Representa os dados de operação dos ônibus.

🔹 Atributos:
dataMes → data da operação
linha → identificação da linha
onibus → veículo
itinerarios → trajeto
problemasRoleta
problemasKm
semAbertura
viagensPrevistas
viagensConcluidas
🔹 Função:
Servir como estrutura de dados (DTO/Entidade)

🗄️ 6. Camada de Repositório
📌 Classe: LinhasRepository

Responsável por buscar dados no banco.

🔹 Método:
public List<Linhas> buscarTodos()
🔹 Funcionamento:
Executa SQL:
SELECT * FROM operacao_onibus
Percorre os resultados (ResultSet)
Converte cada linha em um objeto Linhas
Retorna uma lista com todos os dados

✔ Aqui ocorre a integração com o banco de dados

⚙️ 7. Regras de Negócio
📌 Classe: RegrasLinhas

Responsável por aplicar lógica sobre os dados.

🔹 Método:
public int calcularProblema(int problemas, int viagensConcluidas)
🔹 Regra:
Se viagensConcluidas == 0 → retorna -1
Caso contrário:
Calcula taxa: problemas / viagensConcluidas
Se taxa > 20% → retorna 1 (problema)
Senão → retorna 0 (sem problema)

✔ Essa regra transforma dados brutos em indicadores (binário)

📄 8. Geração do Excel
📌 Classe: CriaArquivoExcel

Responsável por criar o arquivo Excel automaticamente.

🔹 Método principal:
public void criarArquivo(String nomeArquivo, List<Linhas> linhas)
🔹 Etapas:
Cria o arquivo Excel (XSSFWorkbook)
Cria uma planilha
Adiciona cabeçalho
Percorre os dados
Preenche as células
Aplica regras de negócio
Salva o arquivo
🔹 Métodos auxiliares:
➤ adicionarCabecalho

Cria a primeira linha com títulos das colunas.

➤ adicionarCelulaString

Adiciona texto na célula.

➤ adicionarCelulaInt

Adiciona números na célula.

🚀 9. Classe Principal (Execução)

📌 Classe: teste
🔹 Método main:
public static void main(String[] args)
🔹 Fluxo:
Instancia o repositório
Busca dados do banco
Gera o arquivo Excel
LinhasRepository repo = new LinhasRepository();
List<Linhas> dados = repo.buscarTodos();

new CriaArquivoExcel().criarArquivo("relatorioTest.xlsx", dados);

🔄 10. Fluxo Geral do Sistema
Banco de Dados (PostgreSQL)
        ↓
LinhasRepository (consulta SQL)
        ↓
Lista de objetos Linhas
        ↓
RegrasLinhas (cálculos)
        ↓
CriaArquivoExcel (geração do Excel)
        ↓
Arquivo .xlsx final
