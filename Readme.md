PROJECT STRUCTURE :

        socialguard
        │
        ├── controller
        │   ├── PostController
        │   └── CommentController
        │
        ├── service
        │   ├── PostService
        │   ├── CommentService
        │   ├── RedisService  
        │   └── NotificationService
        │
        ├── repository
        │   ├── PostRepository
        │   ├── CommentRepository
        │   ├── UserRepository
        │   └── BotRepository
        │
        ├── entity
        │   ├── User
        │   ├── Bot
        │   ├── Post
        │   └── Comment
        │
        ├── config
        │   ├── RedisConfig
        │   └── SchedulerConfig
        │
        ├── dto
        │   ├── PostRequestDTO
        │   ├── CommentRequestDTO
        │
        ├── exception
        │   ├── GlobalExceptionHandler
        │   └── CustomExceptions
        │
        └── SocialguardApplication