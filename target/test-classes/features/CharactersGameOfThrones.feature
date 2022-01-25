#language: pt
#Author: Paloma Pedro Rodrigues
#Version: 1.0
#Encoding: UTF-8


@CharactersGameOfThrones
Funcionalidade: Gerenciar consulta e cadastro de novos personagens
  Eu como Administradora do sistema GameOfThrones, quero consultar e cadastrar novos personagens

  @post
  Cenario: Cadastrar novo personagem Api GameOfThornes
    Dado que Api GameOfThrones  não solicita token
    Quando envio um request de cadastro de personagem com dados validos
    Entao o personagem deve ser criado com sucesso
    E o status code do requeste deve ser 200

  @get
    Cenario: Consultar dados do personagem Ape GameOfThornes
    Dado que Api GameOfThrones  não solicita token
    E possua um personagem Cadastrado no api
    Quando consulta dados desse personagem
    Entao os dados dos personagens serem retornados
    E o status code do requeste deve ser 200



