# AGENTS.md# Module Strategy for ftt-ui-lib

## Package Structure
Follow this strictly to avoid sprawl:
- `uk.co.fintaxtech.ui.components.<name>`: Standard UI elements (button, card, text).
- `uk.co.fintaxtech.ui.views`: Complex layouts (ErrorView, LoadingView).
- `uk.co.fintaxtech.ui.theme`: Design tokens (color, spacing).
- `uk.co.fintaxtech.ui.modifier`: Custom reusable modifiers.

## Efficiency "Don'ts" (Prevent Revision Loops)
1. **DO NOT** suggest adding Hilt or Dagger to this module.
2. **DO NOT** create a new theme file if one exists; extend the existing `FTTTheme`.
3. **DO NOT** use `mutableStateOf` inside a library component unless strictly necessary for internal animation.
4. **DO NOT** ask for permission to create a Preview; it is mandatory.

## Quick Commands
- Verify Build: `./gradlew :ftt-ui-lib:assembleDebug`
- Run Tests: `./gradlew :ftt-ui-lib:test`