# product-search-service

## 1. 개요

상품, 카테고리, 브랜드를 검색할 수 있는 서비스 입니다.  
이 프로젝트의 기능은 다음을 포함하고 있습니다.

1. 카테고리 별 최저 가격 상품 조회
2. 카테고리 별 모든 상품 구매시 최적 가격을 가진 브랜드 조회
3. 카테고리 이름으로 최저, 최저 가격 상품 조회
4. 상품, 브랜드 CRUD API

이 프로젝트는 다음과 같이 구성되어 있습니다.

1. 사용언어: Kotlin
2. 프레임워크: Spring Boot
3. 데이터베이스: H2
4. 빌드 툴: Gradle
5. 테스트 프레임워크: Kotest

각 기능에 대한 API 명세는 아래 [3. API 명세](#-3.-API-명세)를 참고해주세요.

## 2. 프로젝트 실행 방법

실행 파일 경로: /output/product-search-service-1.0.0.jar
실행
파일: [product-search-service-1.0.0.jar](https://github.com/WonHyeongCho/product-search-service/blob/main/output/product-search-service-1.0.0.jar)   
실행 방법: java -jar product-search-service-1.0.0.jar   
서버 포트: 8080

## 3. API 명세

### 3.1. 카테고리 별 최저 가격 상품 조회 API

### GET _/categories/lowest-price-brands_

#### 요청 파라미터: X

#### 응답 데이터:

| 응답 필드 명                      | 타입          | 설명         |
|------------------------------|-------------|------------|
| productInfoList              | object list | 상품 정보 리스트  |
| productInfoList.price        | number      | 상품 가격      |
| productInfoList.brandName    | string      | 상품 브랜드 이름  |
| productInfoList.categoryName | string      | 상품 카테고리 이름 |
| sumOfMinPrices               | number      | 가격 총 합     |

#### 응답 예시:

```json
{
    "productInfoList": [
        {
            "price": 10000.0,
            "brandName": "C",
            "categoryName": "상의"
        },
        {
            "price": 5000.0,
            "brandName": "E",
            "categoryName": "아우터"
        },
        {
            "price": 3000.0,
            "brandName": "D",
            "categoryName": "바지"
        },
        {
            "price": 9000.0,
            "brandName": "G",
            "categoryName": "스니커즈"
        },
        {
            "price": 2000.0,
            "brandName": "A",
            "categoryName": "가방"
        },
        {
            "price": 1500.0,
            "brandName": "D",
            "categoryName": "모자"
        },
        {
            "price": 1700.0,
            "brandName": "I",
            "categoryName": "양말"
        },
        {
            "price": 1900.0,
            "brandName": "F",
            "categoryName": "악세사리"
        }
    ],
    "sumOfMinPrices": 34100.0
}
```

***

### 3.2. 카테고리 별 모든 상품 구매시 최적 가격을 가진 브랜드 조회 API

### GET _/brands/lowest-total-price_

#### 요청 파라미터: X

#### 응답 데이터:

| 응답 필드 명                                 | 타입          | 설명                   |
|-----------------------------------------|-------------|----------------------|
| lowestPrice                             | object      | 최저 가격 정보             |
| lowestPrice.brand                       | string      | 브랜드 이름               |
| lowestPrice.brand.categories            | object list | 카테고리 정보 리스트          |
| lowestPrice.brand.categories.category   | string      | 카테고리 이름              |
| lowestPrice.brand.categories.price      | string      | 카테고리 상품 가격           |
| lowestPrice.brand.categories.totalPrice | number      | 브랜드 카테고리 별 상품 가격 총 합 |

#### 응답 예시:

```json
{
    "lowestPrice": {
        "brand": "D",
        "categories": [
            {
                "category": "상의",
                "price": 10100.0
            },
            {
                "category": "아우터",
                "price": 5100.0
            },
            {
                "category": "바지",
                "price": 3000.0
            },
            {
                "category": "스니커즈",
                "price": 9500.0
            },
            {
                "category": "가방",
                "price": 2500.0
            },
            {
                "category": "모자",
                "price": 1500.0
            },
            {
                "category": "양말",
                "price": 2400.0
            },
            {
                "category": "악세사리",
                "price": 2000.0
            }
        ],
        "totalPrice": 36100.0
    }
}
```

***

### 3.3. 카테고리 이름으로 최저, 최저 가격 상품 조회 API

### GET _/categories/{category-name}/price-ranges_

#### 요청 파라미터:

| 요청 파라미터 필드 명  | 타입     | 설명      | 요청 파라미터 타입    |
|---------------|--------|---------|---------------|
| category-name | string | 카테고리 이름 | Path Variable |

#### 응답 데이터:

| 응답 필드 명            | 타입     | 설명          |
|--------------------|--------|-------------|
| category           | string | 카테고리 이름     |
| lowestPrice        | object | 최저 가격 상품 정보 |
| lowestPrice.brand  | string | 브랜드 이름      |
| lowestPrice.price  | number | 가격 정보       |
| highestPrice       | object | 최고 가격 상품 정보 |
| highestPrice.brand | string | 브랜드 이름      |
| highestPrice.price | number | 가격 정보       |

#### 응답 예시:

```json
{
    "category": "상의",
    "lowestPrice": {
        "brand": "C",
        "price": 10000.0
    },
    "highestPrice": {
        "brand": "I",
        "price": 11400.0
    }
}
```

***

### 3.4. 상품 조회, 등록, 수정, 삭제

### 3.4.1. 상품 전체 조회

### GET _/products_

#### 요청 파라미터: X

#### 응답 데이터:

| 응답 필드 명       | 타입     | 설명      |
|---------------|--------|---------|
| id            | number | 상품 ID   |
| price         | number | 상품 가격   |
| brand         | object | 브랜드     |
| brand.id      | number | 브랜드 ID  |
| brand.name    | string | 브랜드 이름  |
| category      | object | 카테고리    |
| category.id   | number | 카테고리 ID |
| category.name | string | 카테고리 이름 |

#### 응답 예시:

```json
[
    {
        "id": 1,
        "price": 11200.0,
        "brand": {
            "id": 1,
            "name": "A"
        },
        "category": {
            "id": 1,
            "name": "상의"
        }
    },
    {
        "id": 2,
        "price": 10500.0,
        "brand": {
            "id": 2,
            "name": "B"
        },
        "category": {
            "id": 1,
            "name": "상의"
        }
    },
    {
        "id": 3,
        "price": 10000.0,
        "brand": {
            "id": 3,
            "name": "C"
        },
        "category": {
            "id": 1,
            "name": "상의"
        }
    },
    {
        "id": 4,
        "price": 10100.0,
        "brand": {
            "id": 4,
            "name": "D"
        },
        "category": {
            "id": 1,
            "name": "상의"
        }
    }
]
```

### 3.4.2. 상품 상세 조회

### GET _/products/{id}_

#### 요청 파라미터:

| 요청 파라미터 필드 명 | 타입     | 설명    | 요청 파라미터 타입    |
|--------------|--------|-------|---------------|
| id           | number | 상품 ID | Path Variable |

#### 응답 데이터:

| 응답 필드 명       | 타입     | 설명      |
|---------------|--------|---------|
| id            | number | 상품 ID   |
| price         | number | 상품 가격   |
| brand         | object | 브랜드     |
| brand.id      | number | 브랜드 ID  |
| brand.name    | string | 브랜드 이름  |
| category      | object | 카테고리    |
| category.id   | number | 카테고리 ID |
| category.name | string | 카테고리 이름 |

#### 응답 예시:

```json
{
    "id": 1,
    "price": 11200.0,
    "brand": {
        "id": 1,
        "name": "A"
    },
    "category": {
        "id": 1,
        "name": "상의"
    }
}
```

### 3.4.3. 상품 등록

### POST _/products_

#### 요청 파라미터:

| 요청 파라미터 필드 명 | 타입     | 설명      | 요청 파라미터 타입   |
|--------------|--------|---------|--------------|
| price        | number | 가격      | Request Body |
| brandId      | number | 브랜드 ID  | Request Body |
| categoryId   | number | 카테고리 ID | Request Body |

#### 요청 예시:

```json
{
    "price": 5000,
    "brandId": 1,
    "categoryId": 2
}
```

#### 응답 데이터:

| 응답 필드 명       | 타입     | 설명      |
|---------------|--------|---------|
| id            | number | 상품 ID   |
| price         | number | 상품 가격   |
| brand         | object | 브랜드     |
| brand.id      | number | 브랜드 ID  |
| brand.name    | string | 브랜드 이름  |
| category      | object | 카테고리    |
| category.id   | number | 카테고리 ID |
| category.name | string | 카테고리 이름 |

```json
{
    "id": 73,
    "price": 5000.0,
    "brand": {
        "id": 1,
        "name": "A"
    },
    "category": {
        "id": 2,
        "name": "아우터"
    }
}
```

### 3.4.4. 상품 수정

### PUT _/products/{id}_

#### 요청 파라미터:

| 요청 파라미터 필드 명 | 타입     | 설명      | 요청 파라미터 타입    |
|--------------|--------|---------|---------------|
| id           | number | 상품 ID   | Path Variable |
| brandId      | number | 브랜드 ID  | Request Body  |
| categoryId   | number | 카테고리 ID | Request Body  |

#### 요청 예시:

```json
{
    "price": 4000,
    "brandId": 4,
    "categoryId": 1
}
```

#### 응답 데이터:

| 응답 필드 명       | 타입     | 설명      |
|---------------|--------|---------|
| id            | number | 상품 ID   |
| price         | number | 상품 가격   |
| brand         | object | 브랜드     |
| brand.id      | number | 브랜드 ID  |
| brand.name    | string | 브랜드 이름  |
| category      | object | 카테고리    |
| category.id   | number | 카테고리 ID |
| category.name | string | 카테고리 이름 |

```json
{
    "id": 44,
    "price": 4000.0,
    "brand": {
        "id": 4,
        "name": "D"
    },
    "category": {
        "id": 1,
        "name": "상의"
    }
}
```

### 3.4.5. 상품 삭제

### DELETE _/products/{id}_

#### 요청 파라미터:

| 요청 파라미터 필드 명 | 타입     | 설명    | 요청 파라미터 타입    |
|--------------|--------|-------|---------------|
| id           | number | 상품 ID | Path Variable |

#### 응답 데이터: X

***

### 3.5. 브랜드 조회, 등록, 수정, 삭제

### 3.5.1. 브랜드 전체 조회

### GET _/brands_

#### 요청 파라미터: X

#### 응답 데이터:

| 응답 필드 명 | 타입     | 설명     |
|---------|--------|--------|
| id      | number | 브랜드 ID |
| name    | string | 브랜드 이름 |

#### 응답 예시:

```json
[
    {
        "id": 1,
        "name": "A"
    },
    {
        "id": 2,
        "name": "B"
    }
]
```

### 3.5.2. 브랜드 상세 조회

### GET _/brands/{id}_

#### 요청 파라미터:

| 요청 파라미터 필드 명 | 타입     | 설명     | 요청 파라미터 타입    |
|--------------|--------|--------|---------------|
| id           | number | 브랜드 ID | Path Variable |

#### 응답 데이터:

| 응답 필드 명 | 타입     | 설명     |
|---------|--------|--------|
| id      | number | 브랜드 ID |
| name    | string | 브랜드 이름 |

#### 응답 예시:

```json
{
    "id": 9,
    "name": "I"
}
```

### 3.5.3. 상품 등록

### POST _/brands_

#### 요청 파라미터:

| 요청 파라미터 필드 명 | 타입     | 설명     | 요청 파라미터 타입   |
|--------------|--------|--------|--------------|
| name         | string | 브랜드 이름 | Request Body |

#### 요청 예시:

```json
{
    "name": "AAAA"
}
```

#### 응답 데이터:

| 응답 필드 명 | 타입     | 설명     |
|---------|--------|--------|
| id      | number | 브랜드 ID |
| name    | string | 브랜드 이름 |

```json
{
    "id": 10,
    "name": "AAAA"
}
```

### 3.5.4. 브랜드 수정

### PUT _/brands/{id}_

#### 요청 파라미터:

| 요청 파라미터 필드 명 | 타입     | 설명     | 요청 파라미터 타입    |
|--------------|--------|--------|---------------|
| id           | number | 브랜드 ID | Path Variable |
| name         | string | 브랜드 이름 | Request Body  |

#### 요청 예시:

```json
{
    "name": "ABC"
}
```

#### 응답 데이터:

| 응답 필드 명 | 타입     | 설명     |
|---------|--------|--------|
| id      | number | 브랜드 ID |
| name    | string | 브랜드 이름 |

```json
{
    "id": 10,
    "name": "ABC"
}
```

### 3.5.5. 브랜드 삭제

### DELETE _/brands/{id}_

#### 요청 파라미터:

| 요청 파라미터 필드 명 | 타입     | 설명     | 요청 파라미터 타입    |
|--------------|--------|--------|---------------|
| id           | number | 브랜드 ID | Path Variable |

#### 응답 데이터: X

## 4. Error Code

| 에러 코드 | 에러 메시지               | Http 상태               | 설명                    |
|-------|----------------------|-----------------------|-----------------------|
| 000   | 잘못된 요청입니다.           | BAD_REQUEST           | 잘못된 파라미터 입력 등 잘못된 요청  |
| 001   | 요청하신 데이터를 찾을 수 없습니다. | NOT_FOUND             | 요청 데이터가 존재하지 않음       |
| 002   | 이미 존재하는 데이터입니다.      | BAD_REQUEST           | 이미 존재하는 데이터           |
| 999   | 알 수 없는 오류가 발생했습니다.   | INTERNAL_SERVER_ERROR | 개발자가 정의하지 않은 서버 내부 오류 |
