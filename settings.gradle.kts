plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "shoyoream-application"
include("core")
include("product-application")
include("order-application")
include("payment-application")
include("customer-application")
include("coupon-application")
