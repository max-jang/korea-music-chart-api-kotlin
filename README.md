# Korea Music Chart API

🎵 Korea Music Chart API는 다양한 음악 스트리밍 플랫폼의 한국 실시간 차트 TOP 100 데이터를 제공하는 REST API입니다.
[기존에 Java로 작성된 코드](https://github.com/max-jang/korea-music-chart-api)를 Kotlin으로 새롭게 개발했습니다.

## 📚 Features

- 실시간 차트 조회: 멜론, 지니 등 다양한 음악 스트리밍 플랫폼의 실시간 차트를 조회할 수 있습니다.
- 공통 응답 포맷: 모든 API는 플랫폼과 무관하게 일관된 응답 구조를 제공합니다.

---

## 📖 API Documentation (Swagger)

- **Swagger-UI 제공:** API 명세는 Swagger-UI를 통해 시각적으로 확인할 수 있습니다.
- **접근 방법:** 서버 실행 후 `/swagger-ui/index.html`로 접속하면 전체 API 명세를 확인하고 테스트할 수 있습니다.
- **주요 기능:**
    - 각 API의 요청 및 응답 구조 확인
    - 요청 파라미터 입력 후 실시간 테스트
    - JSON 응답 샘플 제공

---

## 🚀 API Endpoint

### 1. 실시간 차트 조회

- URL: /api/chart/{provider}/realtime
- Method: GET
- Description: 특정 제공자의 실시간 차트를 반환합니다.

#### Request Parameters

| Parameter | Type   | Required | Description | Example |
|-----------|--------|----------|-------------|---------|
| provider  | String | Yes      | 차트 제공자      | melon   |

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
      "previous_rank": 2
    }
  ]
}
```

#### Response Information

| **키 이름**          | **한글명**    | **설명**         | **예시 값**                                                                                 |
|-------------------|------------|----------------|------------------------------------------------------------------------------------------|
| `artist_name`     | 아티스트 이름    | 곡을 부른 아티스트의 이름 | `태민(TAEMIN)`                                                                             |
| `album_name`      | 앨범명        | 곡이 수록된 앨범의 이름  | `Never Gonna Dance Again : Act 1 - The 3rd Album`                                        |
| `song_name`       | 곡명         | 곡의 제목          | `Criminal`                                                                               |
| `album_image_url` | 앨범 이미지 URL | 앨범 이미지의 URL    | `https://cdnimg.melon.co.kr/cm2/album/images/104/86/847/10486847_20200907155042_500.jpg` |
| `song_unique_id`  | 곡 고유 번호    | 곡의 고유 식별자      | `32908826`                                                                               |
| `current_rank`    | 현재 순위      | 차트 내 곡의 현재 순위  | `1`                                                                                      |
| `previous_rank`   | 이전 순위      | 이전 차트에서의 곡의 순위 | `2`                                                                                      |

#### Error Code

| Code | Message                    | Description |
|------|----------------------------|-------------|
| 400  | Bad Request                | 잘못된 요청 파라미터 |
| 404  | Unsupported chart provider | 지원하지 않는 제공자 |

---

## 🛠️ Environment

- Java: JDK 17 이상 설치
- Kotlin: 1.9.25
- Spring Boot: 3.4.1

## 🧑‍💻 Tech Stack

- 언어: Kotlin
- 프레임워크: Spring Boot
- 라이브러리:
    - Jackson: JSON 데이터 처리
    - Springdoc OpenAPI: Swagger 문서 자동 생성
    - RestTemplate: 외부 API 호출