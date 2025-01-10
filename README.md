# Korea Music Chart API

🎵 Korea Music Chart API는 다양한 음악 스트리밍 플랫폼의 한국 실시간 차트 TOP 100 데이터를 제공하는 REST API입니다.
[기존에 Java로 작성된 코드](https://github.com/max-jang/korea-music-chart-api)를 Kotlin으로 새롭게 개발했습니다.

## 📚 주요 기능

- 실시간 차트 조회: 멜론, 지니 등 다양한 음악 스트리밍 플랫폼의 실시간 차트를 조회할 수 있습니다.
- 아티스트 필터링: 특정 아티스트의 곡만 필터링하여 조회할 수 있습니다.
- 공통 응답 포맷: 모든 API는 일관된 응답 구조를 제공합니다.

---

## 🚀 API 엔드포인트

### 1. 실시간 차트 조회

- URL: /api/chart/{provider}/realtime
- Method: GET
- Description: 특정 제공자의 실시간 차트를 반환합니다.

#### Request Parameters

 Parameter | Type   | Required | Description       | Example 
-----------|--------|----------|-------------------|---------
 provider  | String | Yes      | 차트 제공자 (예: genie) | genie   

#### Response Example
```
{
  "code": 200,
  "status": "OK",
  "data": [
    {
      "artist_name": "태민(TAEMIN)",
      "album_name": "Never Gonna Dance Again : Act 1 - The 3rd Album",
      "song_name": "Criminal",
      "album_image_url": "https://cdnimg.melon.co.kr/cm2/album/images/104/86/847/10486847_20200907155042_500.jpg",
      "song_unique_id": "32908826",
      "current_rank": 1,
      "previous_rank": 2,
      "top_rank": 1
    }
  ]
}
```

#### 오류 코드

 Code | Message                    | Description 
------|----------------------------|-------------
 400  | Bad Request                | 잘못된 요청 파라미터 
 404  | Unsupported chart provider | 지원하지 않는 제공자 

---

## 🛠️ 환경

- Java: JDK 17 이상 설치
- Kotlin: 1.9.25
- Spring Boot: 3.4.1

## 🧑‍💻 기술 스택
- 언어: Kotlin
- 프레임워크: Spring Boot
- 라이브러리:
    - Jackson: JSON 데이터 처리
    - Springdoc OpenAPI: Swagger 문서 자동 생성
    - RestTemplate: 외부 API 호출