# jewelry-platform

## 项目定位

Java 21 + Spring Boot 后端多模块仓库，承载珠宝区块链跟踪系统的业务 API、消费者验真 API、异步上链、外部集成和调度任务。

## 目录职责

- `apps/business-api`: 品牌方、鉴定机构、经销商等后台业务 API。
- `apps/verify-api`: 消费者验真查询 API。
- `apps/chain-writer`: 异步上链写入部署单元。
- `apps/integration-worker`: 外部机构、物流和标签事件集成 worker。
- `apps/scheduler`: 周期任务和补偿任务。
- `modules/jewelry-domain`: 珠宝身份、追踪事件和状态机等领域模型。
- `packages/platform-common`: 通用响应、错误码和基础工具类型。

## 标准命令

- `mvn test`
- `mvn package`
- `mvn -pl apps/business-api -am spring-boot:run`
- `mvn -pl apps/verify-api -am spring-boot:run`

## 约束

- 禁止提交真实密钥、证书、连接串、云账号或生产地址。
- 示例配置只能使用占位值。
- 新模块必须接入根 `pom.xml` 聚合构建。
- 提交前运行与改动相关的 Maven 测试。
