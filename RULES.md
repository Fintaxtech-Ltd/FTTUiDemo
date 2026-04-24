# RULES.md

Global hard rules for the FTT Android UI Library repository.

These rules have highest priority. If any AGENTS.md, SKILLS.md, generated code, or user request conflicts with this file, follow RULES.md.

---

## 1. Repository Scope

- This repository is for the Fintaxtech Android UI library.
- The main publishable library module is `ftt-ui-lib`.
- Demo modules (`app`, `feature-demo`) exist only to preview and verify the library.
- Do not add business/domain/data/repository logic to this library.
- Do not add networking, Room, DataStore, Retrofit, repositories, use cases, or feature business logic to `ftt-ui-lib`.

---

## 2. Package & Publishing

- Published Maven coordinates:
  - `groupId = "uk.co.fintaxtech"`
  - `artifactId = "ftt-android-ui-lib"`
- Keep public APIs stable and backwards-compatible where possible.
- Public API changes must be intentional and documented.
- Do not change package coordinates or artifact name unless explicitly requested.
- Do not hardcode secrets or GitHub package credentials.

---

## 3. Kotlin & Compose Rules

- Kotlin only.
- Jetpack Compose only for UI.
- Prefer stateless composables with state hoisted to the caller.
- Components must be reusable across projects.
- Do not make components depend on app-specific navigation, ViewModels, repositories, or business modules.
- Every public composable must:
  - Have clear parameters.
  - Use sensible defaults.
  - Support modifier as the first optional parameter after required content/state.
  - Be previewable where possible.
- Prefer Material 3 components and FTT design tokens/wrappers.
- Do not use wildcard imports.
- Imports must be explicit and alphabetically sorted.
- Prefer `val` over `var`.
- Use minimal visibility: `private` or `internal` for non-public helpers.

---

## 4. Naming Rules

- Public composables should use the `FTT` prefix where appropriate:
  - `FTTButton`
  - `FTTTextField`
  - `FTTCard`
  - `FTTToolbar`
- Theme/design-system objects should also use FTT naming:
  - `FTTTheme`
  - `FTTColors`
  - `FTTTypography`
  - `FTTSpacing`
  - `FTTShape`
- Preview functions should end with `Preview`.
- Test names must follow `action_condition_expectedResult`.

---

## 5. Accessibility Rules

- Interactive components must expose meaningful semantics.
- Icon-only buttons must provide content descriptions or document when null is intentional.
- Components must support large font sizes where practical.
- Do not hardcode text inside reusable library components unless it is sample/preview-only.
- Prefer caller-provided strings.

---

## 6. Theming Rules

- All colors, typography, dimensions, and shapes must flow through FTT theme/design tokens.
- Do not scatter raw colors across components.
- Do not create one-off styling inside components unless it is part of the component contract.
- Support light and dark mode where applicable.
- Components should look correct under `FTTTheme`.

---

## 7. Demo Rules

- `feature-demo` demonstrates library components only.
- Demo screens may contain sample state, sample strings, and sample actions.
- Demo code must not leak into the library module.
- Demo code can use the library as a consumer would.

---

## 8. Testing & Quality

- Add unit tests for pure utilities.
- Add Compose UI tests for interactive components where reasonable.
- Add previews for visual components.
- Do not generate tests with wildcard imports.
- Use `makeSUT()` private factory in tests when object construction is non-trivial.

---

## 9. Output Rules for AI Agents

- Generate one file per code block.
- Each generated code block must start with:
  `// FILE: <relative path>`
- Exactly one `package` declaration per file.
- Do not combine unrelated components in one file.
- Do not mix library and demo packages in the same output block.
