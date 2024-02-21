package shoyoream.server.shoyoreamapplication.application.exception

import shoyoream.server.shoyoreamapplication.application.client.http.model.dto.PayErrorResponse
import shoyoream.server.shoyoreamapplication.core.common.exception.WebClientException

class PayException(detail: PayErrorResponse) :
    WebClientException(detail.toString())
