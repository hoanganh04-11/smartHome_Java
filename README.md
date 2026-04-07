# 🏠 HomeSmartIoT

> Hệ thống nhà thông minh sử dụng **Spring Boot + MySQL + STM32 + ESP32 + LoRa** để giám sát cảm biến và điều khiển thiết bị theo thời gian thực.

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?logo=java" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-green?logo=springboot" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/MySQL-8.0-blue?logo=mysql" alt="MySQL 8"/>
  <img src="https://img.shields.io/badge/STM32-F103C8T6-black" alt="STM32F103C8T6"/>
  <img src="https://img.shields.io/badge/ESP32-WiFi-red" alt="ESP32"/>
  <img src="https://img.shields.io/badge/LoRa-SX1278-purple" alt="LoRa SX1278"/>
  <img src="https://img.shields.io/badge/license-MIT-brightgreen" alt="License"/>
</p>

---

## 📋 Mục lục

- [Giới thiệu](#-giới-thiệu)
- [Tính năng chính](#-tính-năng-chính)
- [Kiến trúc hệ thống](#-kiến-trúc-hệ-thống)
- [Công nghệ sử dụng](#-công-nghệ-sử-dụng)
- [Yêu cầu hệ thống](#️-yêu-cầu-hệ-thống)
- [Cài đặt và chạy dự án](#-cài-đặt-và-chạy-dự-án)
- [Thiết lập cơ sở dữ liệu](#-thiết-lập-cơ-sở-dữ-liệu)
- [Cấu trúc dự án](#-cấu-trúc-dự-án)
- [Chức năng phần cứng](#-chức-năng-phần-cứng)
- [Định hướng phát triển](#-định-hướng-phát-triển)
- [Hướng dẫn đóng góp](#-hướng-dẫn-đóng-góp)
- [Quy ước code](#-quy-ước-code)
- [Thành viên nhóm](#-thành-viên-nhóm)
- [FAQ](#-faq)

---

## 📖 Giới thiệu

**HomeSmartIoT** là dự án xây dựng hệ thống nhà thông minh cho phép:

- Quản lý phòng trong nhà
- Theo dõi dữ liệu cảm biến theo thời gian thực
- Điều khiển thiết bị từ giao diện web
- Cảnh báo khi giá trị cảm biến vượt ngưỡng an toàn
- Kết nối giữa phần cứng và phần mềm thông qua **LoRa** và **ESP32 Gateway**

Dự án hướng đến mô hình IoT thực tế, trong đó:

- **STM32F103C8T6** thu thập dữ liệu cảm biến
- **LoRa SX1278** truyền dữ liệu khoảng cách xa, tiêu thụ thấp
- **ESP32** đóng vai trò gateway
- **Spring Boot + MySQL** xử lý dữ liệu và hiển thị trên website

---

## ✨ Tính năng chính

| Module | Mô tả |
|---|---|
| 🔐 **Đăng nhập** | Xác thực tài khoản người dùng |
| 🏠 **Quản lý phòng** | Thêm, sửa, xóa thông tin phòng |
| 🌡️ **Quản lý cảm biến** | Hiển thị nhiệt độ, độ ẩm, khí gas, ánh sáng |
| 💡 **Quản lý thiết bị** | Bật/tắt thiết bị như đèn, quạt, còi |
| 🚨 **Cảnh báo** | Cảnh báo khi dữ liệu cảm biến vượt ngưỡng |
| 📊 **Dashboard** | Hiển thị tổng quan dữ liệu hệ thống |
| 📡 **Kết nối phần cứng** | Nhận dữ liệu từ STM32/LoRa/ESP32 |
| 👥 **Phân quyền người dùng** | Hỗ trợ Guest / User / Admin |

---

## 📡 Kiến trúc hệ thống

```text
[Cảm biến: MQ2, DHT11, LDR]
            │
            ▼
[STM32F103C8T6 + LoRa SX1278]
            │
            ▼
[ESP32 Gateway + LoRa SX1278]
            │
            ▼
[Spring Boot Server]
            │
            ▼
[MySQL Database]
            │
            ▼
[Web Dashboard / User Interface]
```

### Luồng hoạt động

1. **Node cảm biến** đọc dữ liệu từ MQ2, DHT11, LDR
2. Dữ liệu được đóng gói và gửi qua **LoRa**
3. **ESP32 Gateway** nhận dữ liệu và chuyển lên server
4. **Spring Boot** xử lý, lưu vào **MySQL**
5. Website hiển thị dữ liệu và cho phép người dùng điều khiển thiết bị
6. Lệnh điều khiển có thể được gửi ngược từ web → gateway → node

---

## 📦 Công nghệ sử dụng

| Công nghệ | Vai trò |
|---|---|
| **Java 17** | Ngôn ngữ backend |
| **Spring Boot** | Xây dựng ứng dụng web/backend |
| **Spring MVC** | Xử lý controller và view |
| **MySQL** | Lưu trữ dữ liệu |
| **JPA / Hibernate** | ORM mapping dữ liệu |
| **JSP / HTML / CSS / Bootstrap** | Giao diện web |
| **STM32F103C8T6** | Vi điều khiển node cảm biến |
| **ESP32** | Gateway kết nối phần cứng với server |
| **LoRa SX1278** | Truyền dữ liệu không dây |
| **Git & GitHub** | Quản lý source code |

---

## ⚙️ Yêu cầu hệ thống

| Thành phần | Phiên bản khuyến nghị |
|---|---|
| Java JDK | **17** |
| Maven | **3.8+** |
| MySQL | **8.0+** |
| IDE | VS Code / IntelliJ IDEA / STS |
| STM32CubeMX | Dùng cấu hình phần cứng STM32 |
| STM32CubeIDE | Lập trình cho STM32 |
| Arduino IDE | Lập trình ESP32 |

---

## 🚀 Cài đặt và chạy dự án

### 1. Clone project

```bash
git clone https://github.com/your-username/HomeSmartIoT.git
cd HomeSmartIoT
```

### 2. Cấu hình database trong `application.properties`

```properties
spring.application.name=HomeSmartIoT

spring.datasource.url=jdbc:mysql://localhost:3306/smarthome
spring.datasource.username=root
spring.datasource.password=123456

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

### 3. Chạy project

Nếu đã cài Maven:

```bash
mvn spring-boot:run
```

Nếu dùng Maven Wrapper:

```bash
mvnw.cmd spring-boot:run
```

### 4. Truy cập ứng dụng

```text
http://localhost:8080
```

---

## 🗄️ Thiết lập cơ sở dữ liệu

### Tạo database

```sql
CREATE DATABASE smarthome CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### Một số bảng chính

- `users`
- `roles`
- `rooms`
- `sensors`
- `devices`
- `alerts`

### Quan hệ dữ liệu cơ bản

```text
roles 1 --- n users
rooms 1 --- n sensors
rooms 1 --- n devices
sensors 1 --- n alerts
```

---

## 📁 Cấu trúc dự án

```text
HomeSmartIoT/
├── src/
│   ├── main/
│   │   ├── java/com/smarthome/iot/
│   │   │   ├── controller/         # Xử lý request
│   │   │   ├── service/            # Business logic
│   │   │   ├── repository/         # JPA Repository
│   │   │   ├── model/              # Entity classes
│   │   │   ├── config/             # Cấu hình project
│   │   │   └── HomeSmartIotApplication.java
│   │   └── resources/
│   │       ├── templates/          # Nếu dùng Thymeleaf
│   │       ├── static/             # CSS, JS, Images
│   │       ├── application.properties
│   │       └── META-INF/
├── firmware/
│   ├── stm32/                      # Code STM32
│   └── esp32/                      # Code ESP32 Gateway
├── database/
│   └── smarthome.sql               # Script tạo database
├── docs/
│   └── images/                     # Ảnh giao diện, sơ đồ
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## 🔌 Chức năng phần cứng

### Node cảm biến STM32

- Đọc dữ liệu từ:
  - **MQ2**: cảm biến khí gas
  - **DHT11**: nhiệt độ, độ ẩm
  - **LDR**: ánh sáng
- So sánh với ngưỡng cấu hình
- Điều khiển:
  - **Relay**
  - **Buzzer**
  - **LCD**
- Gửi dữ liệu qua **UART tới module LoRa SX1278**

### Gateway ESP32

- Nhận dữ liệu từ **LoRa**
- Xử lý và gửi dữ liệu lên web server
- Có thể nhận lệnh điều khiển từ server và truyền ngược về node

---

## 📈 Định hướng phát triển

- Thêm biểu đồ dữ liệu theo thời gian thực
- Gửi thông báo qua email hoặc Telegram khi có cảnh báo
- Tích hợp MQTT cho giao tiếp IoT
- Mở rộng phân quyền Admin / User / Guest
- Bổ sung camera hoặc cảm biến chuyển động
- Phát triển mobile app giám sát hệ thống

---

## 🤝 Hướng dẫn đóng góp

### Quy trình làm việc với Git

```bash
git checkout main
git pull origin main
git checkout -b feature/ten-tinh-nang
```

Sau khi code xong:

```bash
git add .
git commit -m "feat: thêm chức năng quản lý phòng"
git push origin feature/ten-tinh-nang
```

Sau đó tạo **Pull Request** lên nhánh `main`.

> Không nên push trực tiếp vào `main` khi làm việc nhóm.

---

## 📝 Quy ước code

### Commit message

Sử dụng format:

```text
<type>: <mô tả ngắn>
```

### Ví dụ

```text
feat: thêm chức năng quản lý thiết bị
fix: sửa lỗi hiển thị dữ liệu cảm biến
docs: cập nhật README
refactor: tối ưu service xử lý cảnh báo
```

### Quy ước đặt tên

| Thành phần | Quy ước | Ví dụ |
|---|---|---|
| Class | `PascalCase` | `UserController` |
| Method / Variable | `camelCase` | `handleLogin()` |
| Constant | `UPPER_SNAKE_CASE` | `MAX_SENSOR_VALUE` |
| Package | `lowercase` | `com.smarthome.iot` |
| Git branch | `kebab-case` | `feature/device-control` |

---

## 👥 Thành viên nhóm

| Họ tên | Vai trò | Công việc |
|---|---|---|
| Nguyễn Văn A | Backend | Spring Boot, MySQL |
| Trần Văn B | Frontend | JSP / Bootstrap |
| Lê Văn C | Hardware | STM32, ESP32, LoRa |
| Phạm Văn D | Database | Thiết kế CSDL |

> Bạn thay lại tên thật của nhóm vào đây.

---

## 🖼️ Ảnh giao diện

Bạn có thể thêm ảnh giao diện như sau:

```md
## 🖼️ Giao diện trang chủ

<p align="center">
  <img src="./docs/images/homepage.png" width="800" alt="Home page"/>
</p>
```

Hoặc ảnh dashboard:

```md
## 🖼️ Dashboard

<p align="center">
  <img src="./docs/images/dashboard.png" width="800" alt="Dashboard"/>
</p>
```

---

## ❓ FAQ

<details>
  <summary><b>Lỗi port 8080 đã được sử dụng?</b></summary>

Kiểm tra process đang chiếm cổng:

```bash
netstat -ano | findstr :8080
```

Sau đó tắt process:

```bash
taskkill /PID <PID> /F
```

</details>

<details>
  <summary><b>Lỗi "mvn is not recognized"?</b></summary>

Bạn chưa cài Maven hoặc chưa thêm Maven vào `PATH`.

Có thể dùng luôn Maven Wrapper:

```bash
mvnw.cmd spring-boot:run
```

</details>

<details>
  <summary><b>Lỗi không kết nối được MySQL?</b></summary>

Kiểm tra lại:

- MySQL đã bật chưa
- Tên database đã đúng chưa
- Username/password đã đúng chưa
- Cổng MySQL có phải `3306` không

</details>

<details>
  <summary><b>Project chạy nhưng không hiện dữ liệu cảm biến?</b></summary>

Kiểm tra lần lượt:

- STM32 đã đọc đúng cảm biến chưa
- LoRa đã truyền dữ liệu chưa
- ESP32 Gateway đã nhận được chưa
- Server đã có API/logic nhận dữ liệu chưa
- Database có lưu dữ liệu không

</details>

---

## 📄 License

Dự án này được phát hành theo giấy phép **MIT**.

---

<p align="center">
  Made with ❤️ by <strong>HomeSmartIoT Team</strong>
</p>
