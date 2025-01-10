# Korea Music Chart API
한국 음악 스트리밍 서비스의 실시간 차트 TOP 100을 제공합니다.

## 변경 사항
- 기존 Java로 작성된 코드를 Kotlin으로 리팩토링하였습니다.

## 지원 플랫폼
- 멜론
- 지니
- 바이브
- 벅스

**기타 플랫폼 지원 예정**

## API 사용 방법
### 실시간 차트 조회
```
/{melon, genie, vibe, bugs}/chart
```
- 실시간 차트 TOP 100을 반환합니다.

### 특정 아티스트 필터링
```
/{melon, genie, vibe, bugs}/chart/{artistName}
```
- 특정 아티스트의 곡만 필터링하여 반환합니다.

## 응답 데이터 예시
### 실시간 차트
```json
{
  "rank": 1, // 현재 순위
  "rankStatus": "static", // 순위 변동 상태 (static, up, down)
  "changedRank": 0, // 순위 변동 값
  "artistName": "태민(TAEMIN)", // 아티스트명
  "title": "Criminal", // 노래명
  "albumName": "Never Gonna Dance Again : Act 1 - The 3rd Album", // 앨범명
  "albumArt": "https://cdnimg.melon.co.kr/cm2/album/images/104/86/847/10486847_20200907155042_500.jpg", // 앨범 아트 이미지 URL
  "songNumber": "32908826" // 노래 고유번호
}
```

### 특이사항
- 멜론은 순위 변경 내역을 제공하지 않습니다. (차트 개편으로 인해 변동 사항 없음)

## 부가기능
### 아티스트 앨범 검색
```
/{melon, genie, vibe, bugs}/albums/{artistName}
```
- 해당 아티스트의 앨범 목록을 검색합니다.

### 앨범 내 곡 검색
```
/{melon, genie, vibe, bugs}/songs/{albumNumber}
```
- 지정된 앨범의 곡 목록을 검색합니다.

## 응답 데이터 예시
### 앨범 검색 결과
```json
{
  "title": "Never Gonna Dance Again : Act 1 - The 3rd Album", // 앨범명
  "number": "10486847" // 앨범 고유번호
}
```

### 앨범 내 곡 검색 결과
```json
{
  "title": "Criminal", // 노래명
  "number": "32908826" // 노래 고유번호
}
```
