package com.github.yusufyilmazfr.podcast4j.constant

import com.github.yusufyilmazfr.podcast4j.config.Config

val testConfig: Config
    get() = Config(
        secret = "qx$" + "4Qr5mCb4aVfVc$" + "cNsq6mUEhEWjsBwt3vVxNNj",
        authKey = "V7YV7YVH6QUE6CGDCZRJ",
        userAgentValue = "FreePodcast",
        timeOutValue = 10000,
    )
