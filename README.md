# File Manager	

## Descri��o    
Leitor de arquivos criado com base na especifica��o proposta no arquivo "Teste para Desenvolvedor", dispon�vel na pasta "src/main/resources" deste projeto.

## Execu��o
Adicionar os arquivos em %HOMEPATH%/data/in (ex. C:\Users\nome_usuario\data\in) com os dados no formato apresentado na especifica��o, gerados utilizando charset UTF-8 e com a extens�o ".dat" (existe um arquivo de exmplo na pasta "resources/data/in") - n�o foram feitas valida��es para os dados de entrada pois n�o foi especificado o comportamento esperado nessa situa��o - em um caso real j� seria problema.
Ao final da leitura, ser� gerado em %HOMEPATH%/data/out um arquivo extens�o ".done.dat" com o mesmo nome do arquivo de entrada. 

#### Utilizando ECLIPSE:
Executar o build pelo Maven(mvn install) para baixar as depend�ncias 

Rodar como projeto Java

#### Valida��o no SONAR Local
Para executar a valida��o, com o Sonar j� instalado na m�quina, � preciso baixar/fazer checkout do projeto e acessar o diretorio do mesmo via CMD ou bash e executar o seguinte comando, trocando o dado XXXXXXXX pelo login do usu�rio: 

	"mvn sonar:sonar \ -Dsonar.host.url=http://localhost:9000 \ -Dsonar.login=XXXXXXXXXXX" 

O resultado da valida��o pode ser visualizado atrav�s do http://localhost:9000, acessando o projeto. 

Foram criados alguns teste unit�rios, mas � poss�vel cobrir muito mais.