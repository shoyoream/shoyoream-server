package shoyoream.server.shoyoreamapplication.application.exception

import shoyoream.server.shoyoreamapplication.core.common.exception.PayError
import shoyoream.server.shoyoreamapplication.core.common.exception.WebClientException

class PayException(detail: PayError) :
    WebClientException(detail.toString())
