import io.kvision.Application
import io.kvision.core.FlexDirection
import io.kvision.core.JustifyContent
import io.kvision.core.TextAlign
import io.kvision.html.div
import io.kvision.html.p
import io.kvision.html.span
import io.kvision.module
import io.kvision.panel.flexPanel
import io.kvision.panel.root
import io.kvision.require
import io.kvision.startApplication
import io.kvision.utils.px
import kotlin.js.Date

class About(private val rootId: String = "about") : Application() {
    init {
        require("./css/index.css")
    }

    override fun start() {

        root(rootId) {
            flexPanel(FlexDirection.ROW, justify = JustifyContent.CENTER) {
                div(className = "aboutWrap") {
                    marginTop = 50.px

                    span(className = "myName") {
                        textAlign = TextAlign.LEFT
                        fontSize = 20.px
                        content = "전지환 - Jeon Jihwan"
                    }

                    p(className = "introduce") {
                        content = """
                            안녕하세요, ${careerCalculation(Date(2022, 9, 19), Date(2024, 11, 15))}년차 백엔드 엔지니어 전지환입니다.
                            저는 결제 정산 도메인으로 커리어를 시작했습니다. 미션 크리티컬한 시스템을 만드는데 관심이 많고 자부심을 갖고 일을 진행하고 있습니다. 도메인 특성상 복잡하고 어려운 문제들을 쉽게 푸는데 노력하고 있습니다.
                            배운 지식을 바탕으로 동료 개발자에게 도움을 주는 데에서 큰 보람을 느낍니다. 단순히 혼자 학습하는데 그치지 않고, 사내 기술발표 세션에서 경험을 공유하거나 대외적으로는 개발자 취준생 멘토링을 하는 활동을 합니다.
                            실무에서는 기능 개발 뿐만 아니라 레거시 시스템 개편, 개발 환경 개선에 흥미를 갖고 노력하고 있습니다.
                        """
                    }
                }
            }
        }
    }

    private fun careerCalculation(begin: Date, end: Date): Int {
        var years = end.getFullYear() - begin.getFullYear()
        val monthDiff = end.getMonth() - begin.getMonth()
        val dayDiff = end.getDate() - begin.getDate()

        if (monthDiff < 0 || (monthDiff == 0 && dayDiff < 0)) {
            years--
        }

        return years
    }
}

fun main() {
    startApplication(::About, module.hot)
}
