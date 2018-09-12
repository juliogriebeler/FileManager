# File Manager	

## Descrição    
Leitor de arquivos criado com base na especificação proposta no arquivo "Teste para Desenvolvedor", disponível na pasta "src/main/resources" deste projeto.

## Execução
Adicionar os arquivos em %HOMEPATH%/data/in (ex. C:\Users\nome_usuario\data\in) com os dados no formato apresentado na especificação, gerados utilizando charset UTF-8 e com a extensão ".dat" (existe um arquivo de exmplo na pasta "resources/data/in") - não foram feitas validações para os dados de entrada pois não foi especificado o comportamento esperado nessa situação - em um caso real já seria problema.
Ao final da leitura, será gerado em %HOMEPATH%/data/out um arquivo extensão ".done.dat" com o mesmo nome do arquivo de entrada. 

#### Utilizando ECLIPSE:
Executar o build pelo Maven(mvn install) para baixar as dependências 

Rodar como projeto Java

#### Validação no SONAR Local
Para executar a validação, com o Sonar já instalado na máquina, é preciso baixar/fazer checkout do projeto e acessar o diretorio do mesmo via CMD ou bash e executar o seguinte comando, trocando o dado XXXXXXXX pelo login do usuário: 

	"mvn sonar:sonar \ -Dsonar.host.url=http://localhost:9000 \ -Dsonar.login=XXXXXXXXXXX" 

O resultado da validação pode ser visualizado através do http://localhost:9000, acessando o projeto. 

Foram criados alguns teste unitários, mas é possível cobrir muito mais.