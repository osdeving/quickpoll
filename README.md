# Quick Poll - A REST API Demo for a quest App

## Lista de resources

- User - Singleton User Resource
- Users - Collection User Resource
- Poll - Singleton Poll Resource
- Polls - Collection Poll Resource
- Vote - Singleton Vote Resource
- Votes - Collection Vote Resource
- ComputeResult - Count Processing Resource

## Exemplo de representação de Poll

```json
{ 
    "id": 2,
    "question": "Quem vai ganhar o Brasileirão esse ano?",
    "options": [
        {
          "id": 45,
          "value": "São Paulo"
        }, 
        {
          "id": 49,
          "value": "Corinthians"
        }, 
        
        {
          "id": 51,
          "value": "Flamengo"
        },
        {
            "id": 54,
            "value": "Palmeiras"
        }
    ]
}
```

## Arquitetura da aplicação

![arquitetura da aplicação](images/quickpoll%20architecture.jpg "quickpoll architecture")
