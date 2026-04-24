# RULES.md
# Global Truths for FTT Android UI Library

## 1. Architectural Constraints
- **Library Scope:** Only reusable UI components. No Business Logic, ViewModels, Repositories, or Networking (Retrofit/Room).
- **Tech Stack:** Kotlin + Jetpack Compose + Material 3.
- **Dependency:** `uk.co.fintaxtech:ftt-android-ui-lib`.

## 2. Component Standards
- **Naming:** Must use `FTT` prefix (e.g., `FTTButton`). Name by component type, not usage (e.g., `FTTTopAppBar`, NOT `FTTActionBar`).
- **State:** Prefer stateless composables; hoist state to callers.
- **Modifiers:** The first optional parameter must be `modifier: Modifier = Modifier`.
- **Theming:** No raw colors or hardcoded DPs. Use `FTTTheme` tokens (Colors, Typography, Spacing, Shape).
- **Strings:** No hardcoded strings. Use `@StringRes textId: Int` or pass `String` from the caller.

## 3. Implementation Rules
- **Visibility:** Use `internal` or `private` for helpers.
- **Imports:** Explicit and alphabetical. No wildcards (`*`).
- **Files:** One public component per file. Start with `// FILE: <path>`.

## 4. Quality & Testing
- **Previews:** Every public component needs a `Preview` wrapped in `FTTTheme`.
- **Tests:** Interactive components require Compose UI tests named `action_condition_expectedResult`.