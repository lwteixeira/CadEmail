# CadEmail

## Primeiros passos a seguir:
 - ChromeDriver deve estar atualizado conforme a versão do Google Chrome instalado na máquina.
 - Deixar o arquivo chromedriver na raiz do projeto.
 - Ter as extenções do cucumber instaladar na idea dentro do projeto.

## Detalhes do funcionamento do projeto

Ao rodar o projeto, irá efetuar um cadastro de email no provedor FASTMAIL.
Por que utilizado esse provedor, pelo fato de não solicitar validação via telefone ou captcha de imagem no primeira cadastro diário.
Ao executar o teste via cucumber, o mesmo irá informa para o cadastro:
- Nome completo.
- Nome email (foi criado um método que gera uma string aleatória)
- Password
- Clica no box para concordar com os termos
- Clicar no botão criar

Caso caso não solicite a confirmação por telefone, o mesmo irá clicar no botão MAIL, e em seguida irá fazer um assertEquals com o email criado.
Após executar o assertEquals o teste irá capturar uma screeshot e salvar a imagem na pasta "CadEmail\target\screenshots"

Caso solicite a confirmação por telefone, o teste irá finalizar e irá capturar um screeshot e salvar na pasta "CadEmail\target\screenshots" com a discrição no inicio do nome do arquivo em "ERRO_...".
