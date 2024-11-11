import io.kvision.Application
import io.kvision.core.*
import io.kvision.html.*
import io.kvision.module
import io.kvision.panel.flexPanel
import io.kvision.panel.root
import io.kvision.require
import io.kvision.startApplication
import io.kvision.utils.px
import kotlinx.browser.window
import kotlin.js.Date

private const val MY_EMAIL_ADDRESS = "jyeonjyan.dev@gmail.com"
private const val MY_LINKEDIN_PROFILE = "https://www.linkedin.com/in/jyeonjyan/"

fun main() {
    startApplication(::App, module.hot)
}

class App(private val rootId: String = "aboutApp") : Application() {
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
                        p(className = "introduceCareerYears") {
                            content = "안녕하세요, ${
                                careerCalculation(
                                    Date(2022, 9, 19), Date(2024, 11, 15)
                                )
                            }년차 백엔드 엔지니어 전지환입니다."
                        }
                        p(content = "저는 미션 크리티컬한 시스템을 만드는데 관심이 많고 자부심을 갖고 일을 진행하고 있습니다. 도메인 특성상 복잡하고 어려운 문제들을 쉽게 푸는데 노력하고 있습니다.")
                        p(content = "배운 지식을 바탕으로 동료 개발자에게 도움을 주는 데에서 큰 보람을 느낍니다. 단순히 혼자 학습하는데 그치지 않고, 사내 기술발표 세션에서 경험을 공유하거나 대외적으로는 개발자 취준생 멘토링을 하는 활동을 합니다.")
                        p(content = "실무에서는 기능 개발 뿐만 아니라 레거시 시스템 개편, 개발 환경 개선에 흥미를 갖고 노력하고 있습니다.")
                    }
                }
            }
            flexPanel(FlexDirection.ROW, justify = JustifyContent.SPACEAROUND) {
                footer(align = Align.CENTER) {
                    div(className = "footerContour") {
                        width = CssSize(100, UNIT.perc)
                        borderTop = Border(color = Color.rgb(224, 225, 229), style = BorderStyle.SOLID)
                    }
                    div(className = "contactMethodWrap", align = Align.CENTER) {
                        marginTop = CssSize(30, UNIT.px)
                        button(className = "infoBtn", text = "Contact with Email") {
                            padding = CssSize(5, UNIT.px)
                            marginRight = CssSize(20, UNIT.px)
                        }.onClick {
                            saveOnClipboard(MY_EMAIL_ADDRESS)
                        }
                        button(className = "infoBtn", text = "View LinkedIn profile") {
                            padding = CssSize(5, UNIT.px)
                        }.onClick {
                            openInNewTap(MY_LINKEDIN_PROFILE)
                        }
                    }
                }
            }
        }

    }
}

private fun careerCalculation(begin: Date, end: Date): Int {
    // 연차의 경우 당해년도를 포함하여 계산한다.
    return (end.getFullYear() - begin.getFullYear()) + 1
}

private fun saveOnClipboard(text: String) {
    window.navigator.clipboard.writeText(text)
    callConfirmDialog("Copied! Email address is now on your clipboard.")
}

private fun openInNewTap(url: String) {
    window.open(url)
}

private fun callConfirmDialog(content: String) {
    window.self.confirm(content)
}
